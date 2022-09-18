package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_23
   extends TilingType
{
   public TilingTypeNC6_23(){
      super( "NC6-23", 7, SymmetryType.pmg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{360,100,100};
      paramDef = new int[]{170, 30,  0};
      paramName = new String[]{"Angle", "Relative length", "Offset"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,3, 0,0,5, 1},
            {1, 6,5, 1,5,6, 1},
            {0, 0,5, 2,4,3, 0},

            {0, 3,4, 0,3,4, 1},
            {1, 4,3, 4,0,5, 0},
            {1, 6,5, 5,5,6, 0},
            {0, 0,5, 6,4,3, 1},
      };
      info = "b=c=d=f\na=e\nB+C=360\nD+E=180\nA+B+E=360\n(A+F=180)";
      labels = new int[]{0,1,2,3,4,5,-1};
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 1.0;
      double a = getParam(paramValues, 0);
      double ln1 = lntotal * getParam(paramValues, 1)/100;
      double ln2 = lntotal - ln1;
      double os = getParam(paramValues, 2)/100;
      
      double ang = 90-a/2;
      double c = ln1 * Math.cos( ang * DEG2RAD );
      double s = ln1 * Math.sin( ang * DEG2RAD );
      
      baseTile.setPoint(0,   0,   0);
      baseTile.setPoint(1,   c,  -s);
      baseTile.setPoint(2, 2*c,   0);
      baseTile.setPoint(3, 3*c,  -s);
      baseTile.setPoint(4, 2*c, ln2-s);
      baseTile.setPoint(5,   c, ln2);
      baseTile.setPoint(6,   c*os, ln2*os);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[0].getX(3);
      offsets[1] = tiles[0].getY(4)-tiles[0].getY(3);
      offsets[2] = tiles[7].getX(3)-tiles[3].getX(3);
      offsets[3] = tiles[7].getY(3)-tiles[3].getY(3);
   }
}