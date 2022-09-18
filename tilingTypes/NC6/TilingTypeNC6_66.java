package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_66
   extends TilingType
{
   public TilingTypeNC6_66(){
      super( "NC6-66", 6, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0,  0};
      paramMax = new int[]{100,100,100,100};
      paramDef = new int[]{ 35, 35, 20, 30};
      paramName = new String[]{"Aspect", "Indent", "Relative Length", "Offset"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,0,1, 0},
            {1, 3,0, 1,0,3, 0},
            {0, 1,0, 2,0,1, 0},

            {0, 4,0, 0,2,4, 1},
            {1, 1,0, 4,0,1, 1},
            {1, 3,0, 5,0,3, 1},
            {0, 1,0, 6,0,1, 1},
      };
      info = "a=e\nd=f\nD=E\nE+F=360\n(A+B+C+D=360)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 1.5;
      double w = lntotal * getParam(paramValues, 0)/100;
      double h = (lntotal - w)/2;
      double ln1 = h * getParam(paramValues, 2)/50;

      double ind = ( getParam(paramValues, 1)/50    - .5 )* w;
      double os = getParam(paramValues, 3)/50 * h;

      baseTile.setPoint(0,  -ind,  0);
      baseTile.setPoint(1,  w+ind, os);
      baseTile.setPoint(2,  -ind, 2*h);
      baseTile.setPoint(3,  +ind, h+ln1);
      baseTile.setPoint(4,  +ind, h);
      baseTile.setPoint(5,  -ind, ln1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(4)-tiles[7].getX(0);
      offsets[3] = tiles[3].getY(4)-tiles[7].getY(0);
   }
}