package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_10
   extends TilingType
{
   public TilingTypeNC6_10(){
      super( "NC6-10", 6, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{240};
      paramDef = new int[]{ 90};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,3,2, 0},
            {0, 0,1, 1,2,1, 0},
            {1, 0,1, 2,3,2, 0},

            {0, 4,3, 0,0,5, 1},
            {1, 0,1, 4,3,2, 1},
            {0, 0,1, 5,2,1, 1},
            {1, 0,1, 6,3,2, 1},
      };
      info = "b=c=d=f\na=e\n2B+C=360\nE+F=360\nA+C+E=360\n(B+D+F=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .5;
      double a = getParam(paramValues, 0)/2;
      double c = ln * Math.cos( a * DEG2RAD );
      double s = ln * Math.sin( a * DEG2RAD );

      baseTile.setPoint(0,   0,    0);
      baseTile.setPoint(1,  ln,    0);
      baseTile.setPoint(2,ln+c,    s);
      baseTile.setPoint(3,  ln,  s+s);
      baseTile.setPoint(4,(ln+c)/2, s+s/2);
      baseTile.setPoint(5,(ln-c)/2, s/2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(3)-tiles[0].getX(3);
      offsets[1] = tiles[3].getY(3)-tiles[0].getY(3);
      offsets[2] = tiles[5].getX(3)-tiles[2].getX(5);
      offsets[3] = tiles[5].getY(3)-tiles[2].getY(5);
   }
}