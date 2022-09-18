package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_51b
   extends TilingType
{
   public TilingTypeNC6_51b(){
      super( "NC6-51b", 6, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 50, 60};
      paramName = new String[]{"Aspect", "Indentation"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 5,0, 0,0,5, 0},
            {0, 0,1, 1,0,1, 1},
            {1, 5,0, 2,0,5, 1},

            {0, 4,3, 0,3,4, 0},
            {1, 5,0, 4,0,5, 0},
            {0, 0,1, 5,0,1, 1},
            {1, 5,0, 6,0,5, 1},
      };
      info = "c=d=e=f\nC+D=360\nC=E\n2B+C=360\n(A+F=B)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 2.0;
      double ln1 = lntotal * getParam(paramValues, 0)/100;
      double ln2 = (lntotal - ln1)/4;
      double ind = ln1 * ( getParam(paramValues, 1)/100*2/3 -1./6 );
      
      baseTile.setPoint(0,     ind,  0);
      baseTile.setPoint(1, ln1-ind,  0);
      baseTile.setPoint(2, ln1+ind, ln2);
      baseTile.setPoint(3, ln1-ind, ln2*2);
      baseTile.setPoint(4, ln1+ind, ln2*3);
      baseTile.setPoint(5, ln1-ind, ln2*4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[6].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[6].getY(2)-tiles[0].getY(0);
   }
}