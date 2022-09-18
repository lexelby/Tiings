package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01o7
   extends TilingType
{
   public TilingTypeN5_01o7(){
      super( "N5-1o7", 5, SymmetryType.p2 );

      paramMin = new int[]{ 90,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{110, 20};
      paramName = new String[]{ "Angle", "Offset"};
      // 0=ori, 1=scale=horiz width,  2=angle of parallel sides, 3=hor/vert ratio, 4=parside split, 5=dist

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,4, 0,0,1, 0},
            {1, 2,3, 1,3,2, 0},
            {0, 0,1, 2,0,4, 0},
      };
      info = "a=b=2c=2e\nC+D=180\nA=E\n(A+B+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double c = Math.cos( paramValues[0] * DEG2RAD );
      double s = Math.sin( paramValues[0] * DEG2RAD );
      double ln1 = .6;
      double ln3 = ln1/2; //side split

      double x1 = ln1 * s;
      double y1 = ln1 * c;
      double x2 = x1 + ln3 * s;
      double y2 = y1 - ln3 * c;
      double x4 = 0;
      double y4 = ln1;
      double x3 = ln3 * s;
      double y3 = ln1 - ln3 * c;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      double os = paramValues[1]/100.;
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(2);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(2);
      offsets[2] = tiles[3].getX(2)-tiles[0].getX(3)+ os * offsets[0];
      offsets[3] = tiles[3].getY(2)-tiles[0].getY(3)+ os * offsets[1];
   }
}
